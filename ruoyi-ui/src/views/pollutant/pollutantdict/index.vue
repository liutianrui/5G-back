<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="污染物类别编码" prop="code">
        <el-input
          v-model="queryParams.code"
          placeholder="请输入污染物类别编码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="编码对应中文名称" prop="desCode">
        <el-input
          v-model="queryParams.desCode"
          placeholder="请输入编码对应中文名称"
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
          v-hasPermi="['pollutant:pollutantdict:add']"
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
          v-hasPermi="['pollutant:pollutantdict:edit']"
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
          v-hasPermi="['pollutant:pollutantdict:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['pollutant:pollutantdict:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="pollutantdictList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键id" align="center" prop="id" />
      <el-table-column label="污染物类别编码" align="center" prop="code" />
      <el-table-column label="编码对应中文名称" align="center" prop="desCode" />
      <el-table-column label="浓度数据类型 N14.2:用可变长字符串形式表达的数字型，表示 14 位整数和 2 位小数，带小数点，带符号，最大长度为 18;" align="center" prop="consisitenceDataType" />
      <el-table-column label="浓度默认计量单位 例如：纳克/立方米" align="center" prop="consisitenceMeas" />
      <el-table-column label="排放量默认计量单位 例如：分贝、克" align="center" prop="emissionsMeas" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['pollutant:pollutantdict:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['pollutant:pollutantdict:remove']"
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

    <!-- 添加或修改污染物排放对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="污染物类别编码" prop="code">
          <el-input v-model="form.code" placeholder="请输入污染物类别编码" />
        </el-form-item>
        <el-form-item label="编码对应中文名称" prop="desCode">
          <el-input v-model="form.desCode" placeholder="请输入编码对应中文名称" />
        </el-form-item>
        <el-form-item label="原始编码" prop="originalCode">
          <el-input v-model="form.originalCode" placeholder="请输入原始编码" />
        </el-form-item>
        <el-form-item label="浓度默认计量单位 例如：纳克/立方米" prop="consisitenceMeas">
          <el-input v-model="form.consisitenceMeas" placeholder="请输入浓度默认计量单位 例如：纳克/立方米" />
        </el-form-item>
        <el-form-item label="排放量默认计量单位 例如：分贝、克" prop="emissionsMeas">
          <el-input v-model="form.emissionsMeas" placeholder="请输入排放量默认计量单位 例如：分贝、克" />
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
import { listPollutantdict, getPollutantdict, delPollutantdict, addPollutantdict, updatePollutantdict } from "@/api/pollutant/pollutantdict";

export default {
  name: "Pollutantdict",
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
      // 污染物排放表格数据
      pollutantdictList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        code: null,
        desCode: null,
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
    /** 查询污染物排放列表 */
    getList() {
      this.loading = true;
      listPollutantdict(this.queryParams).then(response => {
        this.pollutantdictList = response.rows;
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
        code: null,
        desCode: null,
        originalCode: null,
        consisitenceDataType: null,
        consisitenceMeas: null,
        emissionsMeas: null
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
      this.title = "添加污染物排放";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getPollutantdict(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改污染物排放";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updatePollutantdict(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPollutantdict(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除污染物排放编号为"' + ids + '"的数据项？').then(function() {
        return delPollutantdict(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('pollutant/pollutantdict/export', {
        ...this.queryParams
      }, `pollutantdict_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
