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
      <el-form-item label="车牌号" prop="carNumber">
        <el-input
          v-model="queryParams.carNumber"
          placeholder="请输入车牌号"
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
          v-hasPermi="['weigh:bridge:add']"
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
          v-hasPermi="['weigh:bridge:edit']"
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
          v-hasPermi="['weigh:bridge:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['weigh:bridge:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <div style="height: 280px;margin-bottom: 10px;" id="barChart"></div>

    <el-table v-loading="loading" :data="bridgeList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
<!--      <el-table-column label="数据唯一性识别" align="center" prop="id" />-->
      <el-table-column label="所属标段名称" align="center" prop="sectionName" />
      <el-table-column label="设备编号" align="center" prop="equipmentNumber" />
      <el-table-column label="设备名称" align="center" prop="equipmentName" />
      <el-table-column label="供应商" align="center" prop="materialVendor" />
      <el-table-column label="物资种类" align="center" prop="materialType" />
      <el-table-column label="物资规格" align="center" prop="materialSpec" />
      <el-table-column label="发货地点" align="center" prop="sendingPlace" />
      <el-table-column label="收货地点" align="center" prop="receivingPlace" />
      <el-table-column label="毛重" align="center" prop="grossWeight" />
      <el-table-column label="皮重车重" align="center" prop="tareWeight" />
      <el-table-column label="净重" align="center" prop="netWeight" />
      <el-table-column label="结算重量" align="center" prop="countingWeight" />
      <el-table-column label="实际重量" align="center" prop="actualWeight" />
      <el-table-column label="车牌号" align="center" prop="carNumber" />
      <el-table-column label="进场时间" align="center" prop="entryTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.entryTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="出场时间" align="center" prop="exitTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.exitTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['weigh:bridge:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['weigh:bridge:remove']"
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

    <!-- 添加或修改地磅对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="任务单ID" prop="taskNo">
          <el-input v-model="form.taskNo" placeholder="请输入任务单ID" />
        </el-form-item>
        <el-form-item label="所属项目ID" prop="organizationId">
          <el-input v-model="form.organizationId" placeholder="请输入所属项目ID" />
        </el-form-item>
        <el-form-item label="所属标段名称" prop="sectionName">
          <el-input v-model="form.sectionName" placeholder="请输入所属标段名称" />
        </el-form-item>
        <el-form-item label="所属标段ID" prop="sectionId">
          <el-input v-model="form.sectionId" placeholder="请输入所属标段ID" />
        </el-form-item>
        <el-form-item label="所属拌合站名称" prop="mixingStationName">
          <el-input v-model="form.mixingStationName" placeholder="请输入所属拌合站名称" />
        </el-form-item>
        <el-form-item label="所属拌合站ID" prop="mixingStationCode">
          <el-input v-model="form.mixingStationCode" placeholder="请输入所属拌合站ID" />
        </el-form-item>
        <el-form-item label="设备编号" prop="equipmentNumber">
          <el-input v-model="form.equipmentNumber" placeholder="请输入设备编号" />
        </el-form-item>
        <el-form-item label="设备名称" prop="equipmentName">
          <el-input v-model="form.equipmentName" placeholder="请输入设备名称" />
        </el-form-item>
        <el-form-item label="品牌" prop="materialBrand">
          <el-input v-model="form.materialBrand" placeholder="请输入品牌" />
        </el-form-item>
        <el-form-item label="供应商" prop="materialVendor">
          <el-input v-model="form.materialVendor" placeholder="请输入供应商" />
        </el-form-item>
        <el-form-item label="物资规格" prop="materialSpec">
          <el-input v-model="form.materialSpec" placeholder="请输入物资规格" />
        </el-form-item>
        <el-form-item label="批次" prop="materialBatch">
          <el-input v-model="form.materialBatch" placeholder="请输入批次" />
        </el-form-item>
        <el-form-item label="生产日期" prop="productionDate">
          <el-date-picker clearable
            v-model="form.productionDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择生产日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="发货地点" prop="sendingPlace">
          <el-input v-model="form.sendingPlace" placeholder="请输入发货地点" />
        </el-form-item>
        <el-form-item label="收货地点" prop="receivingPlace">
          <el-input v-model="form.receivingPlace" placeholder="请输入收货地点" />
        </el-form-item>
        <el-form-item label="毛重" prop="grossWeight">
          <el-input v-model="form.grossWeight" placeholder="请输入毛重" />
        </el-form-item>
        <el-form-item label="皮重车重" prop="tareWeight">
          <el-input v-model="form.tareWeight" placeholder="请输入皮重车重" />
        </el-form-item>
        <el-form-item label="净重" prop="netWeight">
          <el-input v-model="form.netWeight" placeholder="请输入净重" />
        </el-form-item>
        <el-form-item label="扣量" prop="deduction">
          <el-input v-model="form.deduction" placeholder="请输入扣量" />
        </el-form-item>
        <el-form-item label="结算重量" prop="countingWeight">
          <el-input v-model="form.countingWeight" placeholder="请输入结算重量" />
        </el-form-item>
        <el-form-item label="实际重量" prop="actualWeight">
          <el-input v-model="form.actualWeight" placeholder="请输入实际重量" />
        </el-form-item>
        <el-form-item label="车牌号" prop="carNumber">
          <el-input v-model="form.carNumber" placeholder="请输入车牌号" />
        </el-form-item>
        <el-form-item label="进场时间" prop="entryTime">
          <el-date-picker clearable
            v-model="form.entryTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择进场时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="出场时间" prop="exitTime">
          <el-date-picker clearable
            v-model="form.exitTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择出场时间">
          </el-date-picker>
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
import { listBridge, getBridge, delBridge, addBridge, updateBridge, getPieEcharts, getBarEcharts } from "@/api/weigh/bridge";
import * as echarts from 'echarts';
export default {
  name: "Bridge",
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
      // 地磅表格数据
      bridgeList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        equipmentNumber: null,
        carNumber: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        taskNo: [
          { required: true, message: "任务单ID不能为空", trigger: "blur" }
        ],
        organizationId: [
          { required: true, message: "所属项目ID不能为空", trigger: "blur" }
        ],
        sectionId: [
          { required: true, message: "所属标段ID不能为空", trigger: "blur" }
        ],
        mixingStationCode: [
          { required: true, message: "所属拌合站ID不能为空", trigger: "blur" }
        ],
        equipmentNumber: [
          { required: true, message: "设备编号不能为空", trigger: "blur" }
        ],
        materialBrand: [
          { required: true, message: "品牌不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询地磅列表 */
    getList() {
      this.getBarEchartsData()
      this.loading = true;
      listBridge(this.queryParams).then(response => {
        this.bridgeList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    getBarEchartsData(){
      getPieEcharts(this.queryParams).then((data)=>{
        this.createBarEcharts(data);
      })
    },
    createBarEcharts(data){
      let xData=[]
      let seriesData=[]
      for (let item of data.data){
        xData.push(item.materialType)
        seriesData.push(item.netWeight)
      }
      this.barChart = echarts.init(document.getElementById('barChart'))
      this.barChart.clear()
      let option = {
        color: ['#4A79FF'],
        tooltip: {
          trigger: 'axis',
          axisPointer: {            // 坐标轴指示器，坐标轴触发有效
            type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
          },
          formatter: function (params) {
            return  params[0].name + '<br> ' + params[0].marker +  params[0].value + '吨';
          }
        },
        grid: {
          top:'10%',
          left: '3%',
          right: '5%',
          bottom: '4%',
          containLabel: true
        },
        xAxis: [
          {
            type: 'category',
            data: xData,
            axisLabel: {
              interval:0, //强制显示文字
              show: true
            }
          }
        ],
        yAxis: [
          {
            type: 'value',
            name: '吨'
          }
        ],
        series: [
          {
            /*name: '物料类型',*/
            type: 'bar',
            barWidth: '40',
            data: seriesData,
            itemStyle: {        //上方显示数值
              normal: {
                label: {
                  show: true, //开启显示
                  position: 'top', //在上方显示
                  textStyle: { //数值样式
                    color: 'black',
                    fontSize: 12
                  }
                }
              }
            }
          }
        ]
      };

      this.barChart.setOption(option,true)

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
        taskNo: null,
        organizationId: null,
        sectionName: null,
        sectionId: null,
        mixingStationName: null,
        mixingStationCode: null,
        equipmentNumber: null,
        equipmentName: null,
        materialBrand: null,
        materialVendor: null,
        materialType: null,
        materialSpec: null,
        materialBatch: null,
        productionDate: null,
        sendingPlace: null,
        receivingPlace: null,
        grossWeight: null,
        tareWeight: null,
        netWeight: null,
        deduction: null,
        countingWeight: null,
        actualWeight: null,
        carNumber: null,
        entryTime: null,
        exitTime: null,
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
      this.title = "添加地磅";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getBridge(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改地磅";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateBridge(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addBridge(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除地磅编号为"' + ids + '"的数据项？').then(function() {
        return delBridge(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('weigh/bridge/export', {
        ...this.queryParams
      }, `bridge_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
