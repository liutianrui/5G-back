import request from '@/utils/request'

// 查询沥青混凝土收集列表
export function listAsphalt_concrete_collection(query) {
  return request({
    url: '/asphalt/asphalt_concrete_collection/list',
    method: 'get',
    params: query
  })
}

// 查询沥青混凝土收集详细
export function getAsphalt_concrete_collection(id) {
  return request({
    url: '/asphalt/asphalt_concrete_collection/' + id,
    method: 'get'
  })
}

// 新增沥青混凝土收集
export function addAsphalt_concrete_collection(data) {
  return request({
    url: '/asphalt/asphalt_concrete_collection',
    method: 'post',
    data: data
  })
}

// 修改沥青混凝土收集
export function updateAsphalt_concrete_collection(data) {
  return request({
    url: '/asphalt/asphalt_concrete_collection',
    method: 'put',
    data: data
  })
}

// 删除沥青混凝土收集
export function delAsphalt_concrete_collection(id) {
  return request({
    url: '/asphalt/asphalt_concrete_collection/' + id,
    method: 'delete'
  })
}

export function getEchartData(data){
  return request({
    url: '/asphalt/asphalt_concrete_collection/queryBar',
    method: 'get',
    params: data
  })
}
