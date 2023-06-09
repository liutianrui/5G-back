<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="拌合站编号" prop="mixingStationCode">
        <el-input
          v-model="queryParams.mixingStationCode"
          placeholder="请输入拌合站编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="设备名称" prop="mixingMachineName">
        <el-input
          v-model="queryParams.mixingMachineName"
          placeholder="请输入设备名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="设备编号" prop="equipmentNumber">
        <el-input
          v-model="queryParams.equipmentNumber"
          placeholder="请输入设备编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['mixingmachine:mixingmachineinfo:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['mixingmachine:mixingmachineinfo:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['mixingmachine:mixingmachineinfo:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['mixingmachine:mixingmachineinfo:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="mixingmachineinfoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="设备id" align="center" prop="mixingmachineId" />
      <el-table-column label="拌合站编号" align="center" prop="mixingStationCode" />
      <el-table-column label="设备名称" align="center" prop="mixingMachineName" />
      <el-table-column label="缩写" align="center" prop="abbreviation" />
      <el-table-column label="设备编号" align="center" prop="equipmentNumber" />
      <el-table-column label="制造商" align="center" prop="manufacturer" />
      <el-table-column label="项目标段id" align="center" prop="sectionProjectId" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['mixingmachine:mixingmachineinfo:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['mixingmachine:mixingmachineinfo:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改搅拌机信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="拌合站编号" prop="mixingStationCode">
          <el-input v-model="form.mixingStationCode" placeholder="请输入拌合站编号" />
        </el-form-item>
        <el-form-item label="设备名称" prop="mixingMachineName">
          <el-input v-model="form.mixingMachineName" placeholder="请输入设备名称" />
        </el-form-item>
        <el-form-item label="缩写" prop="abbreviation">
          <el-input v-model="form.abbreviation" placeholder="请输入缩写" />
        </el-form-item>
        <el-form-item label="设备编号" prop="equipmentNumber">
          <el-input v-model="form.equipmentNumber" placeholder="请输入设备编号" />
        </el-form-item>
        <el-form-item label="制造商" prop="manufacturer">
          <el-input v-model="form.manufacturer" placeholder="请输入制造商" />
        </el-form-item>
        <el-form-item label="项目标段id" prop="sectionProjectId">
          <el-input v-model="form.sectionProjectId" placeholder="请输入项目标段id" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listMixingmachineinfo, getMixingmachineinfo, delMixingmachineinfo, addMixingmachineinfo, updateMixingmachineinfo } from "@/api/mixingmachine/mixingmachineinfo";

export default {
  name: "Mixingmachineinfo",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 搅拌机信息表格数据
      mixingmachineinfoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        mixingStationCode: null,
        mixingMachineName: null,
        equipmentNumber: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        equipmentNumber: [
          { required: true, message: "设备编号不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询搅拌机信息列表 */
    getList() {
      this.loading = true;
      listMixingmachineinfo(this.queryParams).then(response => {
        this.mixingmachineinfoList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        mixingmachineId: null,
        mixingStationCode: null,
        mixingMachineName: null,
        abbreviation: null,
        equipmentNumber: null,
        manufacturer: null,
        sectionProjectId: null,
        itemId: null,
        createTime: null,
        isDeleted: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.mixingmachineId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加搅拌机信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const mixingmachineId = row.mixingmachineId || this.ids
      getMixingmachineinfo(mixingmachineId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改搅拌机信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.mixingmachineId != null) {
            updateMixingmachineinfo(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addMixingmachineinfo(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const mixingmachineIds = row.mixingmachineId || this.ids;
      this.$modal.confirm('是否确认删除搅拌机信息编号为"' + mixingmachineIds + '"的数据项？').then(function() {
        return delMixingmachineinfo(mixingmachineIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('mixingmachine/mixingmachineinfo/export', {
        ...this.queryParams
      }, `mixingmachineinfo_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
