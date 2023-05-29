<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="试验机名称" prop="equipmentName">
        <el-input
          v-model="queryParams.equipmentName"
          placeholder="请输入试验机名称"
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
          v-hasPermi="['machine:stressmachine:add']"
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
          v-hasPermi="['machine:stressmachine:edit']"
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
          v-hasPermi="['machine:stressmachine:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['machine:stressmachine:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="stressmachineList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="数据id" align="center" prop="id" />
      <el-table-column label="标段名称" align="center" prop="sectionName" />
      <el-table-column label="试验机名称" align="center" prop="equipmentName" />
      <el-table-column label="施工部位" align="center" prop="constructionSpot" />
      <el-table-column label="试验类型" align="center" prop="testType" />
      <el-table-column label="龄期" align="center" prop="concreteAge" />
      <el-table-column label="试件面积" align="center" prop="cubeArea" />
      <el-table-column label="试件编号" align="center" prop="cubeCode" />
      <el-table-column label="试块个数" align="center" prop="cubeCount" />
      <el-table-column label="${comment}" align="center" prop="loadValue" />
      <el-table-column label="抗压强度" align="center" prop="compressiveStrength" />
      <el-table-column label="强度代表值" align="center" prop="representativeStrength" />
      <el-table-column label="设计强度" align="center" prop="designStrength" />
      <el-table-column label="过程压力" align="center" prop="processStress" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['machine:stressmachine:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['machine:stressmachine:remove']"
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

    <!-- 添加或修改压力机对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="所属项目" prop="organizationId">
          <el-input v-model="form.organizationId" placeholder="请输入所属项目" />
        </el-form-item>
        <el-form-item label="所属标段项目" prop="sectionId">
          <el-input v-model="form.sectionId" placeholder="请输入所属标段项目" />
        </el-form-item>
        <el-form-item label="标段名称" prop="sectionName">
          <el-input v-model="form.sectionName" placeholder="请输入标段名称" />
        </el-form-item>
        <el-form-item label="试验机ID" prop="equipmentNumber">
          <el-input v-model="form.equipmentNumber" placeholder="请输入试验机ID" />
        </el-form-item>
        <el-form-item label="试验机名称" prop="equipmentName">
          <el-input v-model="form.equipmentName" placeholder="请输入试验机名称" />
        </el-form-item>
        <el-form-item label="工程名称" prop="projectName">
          <el-input v-model="form.projectName" placeholder="请输入工程名称" />
        </el-form-item>
        <el-form-item label="施工部位" prop="constructionSpot">
          <el-input v-model="form.constructionSpot" placeholder="请输入施工部位" />
        </el-form-item>
        <el-form-item label="试验id" prop="testId">
          <el-input v-model="form.testId" placeholder="请输入试验id" />
        </el-form-item>
        <el-form-item label="试验日期" prop="testDate">
          <el-date-picker clearable
            v-model="form.testDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择试验日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="龄期" prop="concreteAge">
          <el-input v-model="form.concreteAge" placeholder="请输入龄期" />
        </el-form-item>
        <el-form-item label="试件面积" prop="cubeArea">
          <el-input v-model="form.cubeArea" placeholder="请输入试件面积" />
        </el-form-item>
        <el-form-item label="试件编号" prop="cubeCode">
          <el-input v-model="form.cubeCode" placeholder="请输入试件编号" />
        </el-form-item>
        <el-form-item label="试块个数" prop="cubeCount">
          <el-input v-model="form.cubeCount" placeholder="请输入试块个数" />
        </el-form-item>
        <el-form-item label="${comment}" prop="loadValue">
          <el-input v-model="form.loadValue" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="抗压强度" prop="compressiveStrength">
          <el-input v-model="form.compressiveStrength" placeholder="请输入抗压强度" />
        </el-form-item>
        <el-form-item label="强度代表值" prop="representativeStrength">
          <el-input v-model="form.representativeStrength" placeholder="请输入强度代表值" />
        </el-form-item>
        <el-form-item label="设计强度" prop="designStrength">
          <el-input v-model="form.designStrength" placeholder="请输入设计强度" />
        </el-form-item>
        <el-form-item label="评定结果 0合格，1不合格，2无效，3作废" prop="testEvaluation">
          <el-input v-model="form.testEvaluation" placeholder="请输入评定结果 0合格，1不合格，2无效，3作废" />
        </el-form-item>
        <el-form-item label="过程压力" prop="processStress">
          <el-input v-model="form.processStress" type="textarea" placeholder="请输入内容" />
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
import { listStressmachine, getStressmachine, delStressmachine, addStressmachine, updateStressmachine } from "@/api/machine/stressmachine";

export default {
  name: "Stressmachine",
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
      // 压力机表格数据
      stressmachineList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        equipmentName: null,
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
    /** 查询压力机列表 */
    getList() {
      this.loading = true;
      listStressmachine(this.queryParams).then(response => {
        this.stressmachineList = response.rows;
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
        organizationId: null,
        sectionId: null,
        sectionName: null,
        equipmentNumber: null,
        equipmentName: null,
        projectName: null,
        constructionSpot: null,
        testType: null,
        testId: null,
        testDate: null,
        concreteAge: null,
        cubeArea: null,
        cubeCode: null,
        cubeCount: null,
        loadValue: null,
        compressiveStrength: null,
        representativeStrength: null,
        designStrength: null,
        testEvaluation: null,
        graphId: null,
        processStress: null,
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
      this.title = "添加压力机";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getStressmachine(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改压力机";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateStressmachine(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addStressmachine(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除压力机编号为"' + ids + '"的数据项？').then(function() {
        return delStressmachine(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('machine/stressmachine/export', {
        ...this.queryParams
      }, `stressmachine_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
