<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="设备编号" prop="equipmentNumber">
        <el-input
          v-model="queryParams.equipmentNumber"
          placeholder="请输入设备编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="工程" prop="engineeringSite">
        <el-input
          v-model="queryParams.engineeringSite"
          placeholder="请输入工程"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="试验名称" prop="testName">
        <el-input
          v-model="queryParams.testName"
          placeholder="请输入试验名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="试验日期" prop="testDate">
        <el-date-picker clearable
          v-model="queryParams.testDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择试验日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="样品名称" prop="sampleName">
        <el-input
          v-model="queryParams.sampleName"
          placeholder="请输入样品名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="试件总数" prop="testAllFr">
        <el-input
          v-model="queryParams.testAllFr"
          placeholder="请输入试件总数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="上传时间" prop="uploadTime">
        <el-date-picker clearable
          v-model="queryParams.uploadTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择上传时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="延伸速度" prop="extensionSpeed">
        <el-input
          v-model="queryParams.extensionSpeed"
          placeholder="请输入延伸速度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="延伸值" prop="ductility">
        <el-input
          v-model="queryParams.ductility"
          placeholder="请输入延伸值"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="平均延度" prop="averageDuctility">
        <el-input
          v-model="queryParams.averageDuctility"
          placeholder="请输入平均延度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否合格" prop="result">
        <el-input
          v-model="queryParams.result"
          placeholder="请输入是否合格"
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
          v-hasPermi="['ductility:expductility:add']"
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
          v-hasPermi="['ductility:expductility:edit']"
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
          v-hasPermi="['ductility:expductility:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['ductility:expductility:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="expductilityList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
<!--      <el-table-column label="${comment}" align="center" prop="id" />-->
      <el-table-column label="设备编号" align="center" prop="equipmentNumber" />
      <el-table-column label="设备名称" align="center" prop="equipmentName" />
      <el-table-column label="工程" align="center" prop="engineeringSite" />
      <el-table-column label="试验名称" align="center" prop="testName" />
      <el-table-column label="试验日期" align="center" prop="testDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.testDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="样品名称" align="center" prop="sampleName" />
      <el-table-column label="试件总数" align="center" prop="testAllFr" />
      <el-table-column label="上传时间" align="center" prop="uploadTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.uploadTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="延伸速度" align="center" prop="extensionSpeed" />
      <el-table-column label="延伸值" align="center" prop="ductility" />
      <el-table-column label="平均延度" align="center" prop="averageDuctility" />
      <el-table-column label="是否合格" align="center" prop="result" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['ductility:expductility:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['ductility:expductility:remove']"
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

    <!-- 添加或修改延展性实验对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="设备编号" prop="equipmentNumber">
          <el-input v-model="form.equipmentNumber" placeholder="请输入设备编号" />
        </el-form-item>
        <el-form-item label="设备名称" prop="equipmentName">
          <el-input v-model="form.equipmentName" placeholder="请输入设备名称" />
        </el-form-item>
        <el-form-item label="工程名称" prop="engineeringName">
          <el-input v-model="form.engineeringName" placeholder="请输入工程名称" />
        </el-form-item>
        <el-form-item label="工程" prop="engineeringSite">
          <el-input v-model="form.engineeringSite" placeholder="请输入工程" />
        </el-form-item>
        <el-form-item label="任务编号" prop="taskNo">
          <el-input v-model="form.taskNo" placeholder="请输入任务编号" />
        </el-form-item>
        <el-form-item label="试验名称" prop="testName">
          <el-input v-model="form.testName" placeholder="请输入试验名称" />
        </el-form-item>
        <el-form-item label="试验编号" prop="testNo">
          <el-input v-model="form.testNo" placeholder="请输入试验编号" />
        </el-form-item>
        <el-form-item label="组号" prop="groupId">
          <el-input v-model="form.groupId" placeholder="请输入组号" />
        </el-form-item>
        <el-form-item label="试验日期" prop="testDate">
          <el-date-picker clearable
            v-model="form.testDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择试验日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="试验人员" prop="tester">
          <el-input v-model="form.tester" placeholder="请输入试验人员" />
        </el-form-item>
        <el-form-item label="样品名称" prop="sampleName">
          <el-input v-model="form.sampleName" placeholder="请输入样品名称" />
        </el-form-item>
        <el-form-item label="试件总数" prop="testAllFr">
          <el-input v-model="form.testAllFr" placeholder="请输入试件总数" />
        </el-form-item>
        <el-form-item label="试验次数(试件数量)" prop="testFr">
          <el-input v-model="form.testFr" placeholder="请输入试验次数(试件数量)" />
        </el-form-item>
        <el-form-item label="开始时间" prop="startTime">
          <el-date-picker clearable
            v-model="form.startTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择开始时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="结束时间" prop="endTime">
          <el-date-picker clearable
            v-model="form.endTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择结束时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="上传时间" prop="uploadTime">
          <el-date-picker clearable
            v-model="form.uploadTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择上传时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="试验温度" prop="testTemp">
          <el-input v-model="form.testTemp" placeholder="请输入试验温度" />
        </el-form-item>
        <el-form-item label="延伸速度" prop="extensionSpeed">
          <el-input v-model="form.extensionSpeed" placeholder="请输入延伸速度" />
        </el-form-item>
        <el-form-item label="延伸值" prop="ductility">
          <el-input v-model="form.ductility" placeholder="请输入延伸值" />
        </el-form-item>
        <el-form-item label="平均延度" prop="averageDuctility">
          <el-input v-model="form.averageDuctility" placeholder="请输入平均延度" />
        </el-form-item>
        <el-form-item label="是否合格" prop="result">
          <el-input v-model="form.result" placeholder="请输入是否合格" />
        </el-form-item>
        <el-form-item label="其他信息" prop="otherInformation">
          <el-input v-model="form.otherInformation" type="textarea" placeholder="请输入内容" />
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
import { listExpductility, getExpductility, delExpductility, addExpductility, updateExpductility } from "@/api/ductility/expductility";

export default {
  name: "Expductility",
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
      // 延展性实验表格数据
      expductilityList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        equipmentNumber: null,
        engineeringSite: null,
        testName: null,
        testDate: null,
        sampleName: null,
        testAllFr: null,
        uploadTime: null,
        extensionSpeed: null,
        ductility: null,
        averageDuctility: null,
        result: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询延展性实验列表 */
    getList() {
      this.loading = true;
      listExpductility(this.queryParams).then(response => {
        this.expductilityList = response.rows;
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
        id: null,
        equipmentNumber: null,
        equipmentName: null,
        engineeringName: null,
        engineeringSite: null,
        taskNo: null,
        testType: null,
        testName: null,
        testNo: null,
        groupId: null,
        testDate: null,
        tester: null,
        sampleName: null,
        testAllFr: null,
        testFr: null,
        sampleNo: null,
        startTime: null,
        endTime: null,
        uploadTime: null,
        testTemp: null,
        extensionSpeed: null,
        ductility: null,
        averageDuctility: null,
        curve: null,
        curve1: null,
        result: null,
        otherInformation: null,
        insertTime: null,
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
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加延展性实验";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getExpductility(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改延展性实验";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateExpductility(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addExpductility(this.form).then(response => {
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
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除延展性实验编号为"' + ids + '"的数据项？').then(function() {
        return delExpductility(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('ductility/expductility/export', {
        ...this.queryParams
      }, `expductility_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
