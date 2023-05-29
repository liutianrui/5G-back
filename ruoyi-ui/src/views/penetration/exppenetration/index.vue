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
      <el-form-item label="设备编号" prop="sampleNo">
        <el-input
          v-model="queryParams.sampleNo"
          placeholder="请输入sampleNo"
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
          v-hasPermi="['penetration:exppenetration:add']"
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
          v-hasPermi="['penetration:exppenetration:edit']"
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
          v-hasPermi="['penetration:exppenetration:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['penetration:exppenetration:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="exppenetrationList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
<!--      <el-table-column label="UUID" align="center" prop="id" />-->
      <el-table-column label="设备编号" align="center" prop="equipmentNumber" />
      <el-table-column label="设备名称" align="center" prop="equipmentName" />
      <el-table-column label="工程名称" align="center" prop="engineeringName" />
      <el-table-column label="施工部位" align="center" prop="engineeringSite" />
      <el-table-column label="试验类型" align="center" prop="testType" /><!--针入度试验为 ZRD、软化点试验为 RHD、马歇尔稳定度为 MXEWDD、延度试验为 YD-->
      <el-table-column label="试验日期" align="center" prop="testDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.testDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="样品名称" align="center" prop="sampleName" />
      <el-table-column label="试件总数量" align="center" prop="testAllFr" />
      <el-table-column label="试件序号" align="center" prop="testFr" />
      <el-table-column label="${comment}" align="center" prop="sampleNo" />
      <el-table-column label="上传时间" align="center" prop="uploadTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.uploadTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="针入度" align="center" prop="penetration" />
      <el-table-column label="针入度平均值" align="center" prop="average" /><!--三次平行实验后的平均值-->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['penetration:exppenetration:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['penetration:exppenetration:remove']"
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

    <!-- 添加或修改针入度实验对话框 -->
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
        <el-form-item label="施工部位" prop="engineeringSite">
          <el-input v-model="form.engineeringSite" placeholder="请输入施工部位" />
        </el-form-item>
        <el-form-item label="任务单编号 与平台新建任务单一致，" prop="taskNo">
          <el-input v-model="form.taskNo" placeholder="请输入任务单编号 与平台新建任务单一致，" />
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
        <el-form-item label="试件总数量" prop="testAllFr">
          <el-input v-model="form.testAllFr" placeholder="请输入试件总数量" />
        </el-form-item>
        <el-form-item label="试件序号" prop="testFr">
          <el-input v-model="form.testFr" placeholder="请输入试件序号" />
        </el-form-item>
        <el-form-item label="${comment}" prop="sampleNo">
          <el-input v-model="form.sampleNo" placeholder="请输入${comment}" />
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
        <el-form-item label="入针时间" prop="penetrateTime">
          <el-input v-model="form.penetrateTime" placeholder="请输入入针时间" />
        </el-form-item>
        <el-form-item label="针入度" prop="penetration">
          <el-input v-model="form.penetration" placeholder="请输入针入度" />
        </el-form-item>
        <el-form-item label="针入度平均值 三次平行实验后的平均值" prop="average">
          <el-input v-model="form.average" placeholder="请输入针入度平均值 三次平行实验后的平均值" />
        </el-form-item>
        <el-form-item label="针入度指数 本组试验中有效试验的平均值结果，例如针入度三次试验取得值分别为 85、90、95，平均值为90，同一组试验该值相同" prop="pi">
          <el-input v-model="form.pi" placeholder="请输入针入度指数 本组试验中有效试验的平均值结果，例如针入度三次试验取得值分别为 85、90、95，平均值为90，同一组试验该值相同" />
        </el-form-item>
        <el-form-item label="${comment}" prop="result">
          <el-input v-model="form.result" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="otherInformation">
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
import { listExppenetration, getExppenetration, delExppenetration, addExppenetration, updateExppenetration } from "@/api/penetration/exppenetration";

export default {
  name: "Exppenetration",
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
      // 针入度实验表格数据
      exppenetrationList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        equipmentNumber: null,
        sampleNo: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        equipmentNumber: [
          { required: true, message: "设备编号不能为空", trigger: "blur" }
        ],
        taskNo: [
          { required: true, message: "任务单编号 与平台新建任务单一致，不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询针入度实验列表 */
    getList() {
      this.loading = true;
      listExppenetration(this.queryParams).then(response => {
        this.exppenetrationList = response.rows;
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
        penetrateTime: null,
        penetration: null,
        average: null,
        pi: null,
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
      this.title = "添加针入度实验";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getExppenetration(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改针入度实验";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateExppenetration(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addExppenetration(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除针入度实验编号为"' + ids + '"的数据项？').then(function() {
        return delExppenetration(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('penetration/exppenetration/export', {
        ...this.queryParams
      }, `exppenetration_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
