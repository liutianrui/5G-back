import request from '@/utils/request'

// 查询水泥稳定碎石集料列表
export function listMacadam(query) {
  return request({
    url: '/cementstabilized/macadam/list',
    method: 'get',
    params: query
  })
}

// 查询水泥稳定碎石集料详细
export function getMacadam(id) {
  return request({
    url: '/cementstabilized/macadam/' + id,
    method: 'get'
  })
}

// 新增水泥稳定碎石集料
export function addMacadam(data) {
  return request({
    url: '/cementstabilized/macadam',
    method: 'post',
    data: data
  })
}

// 修改水泥稳定碎石集料
export function updateMacadam(data) {
  return request({
    url: '/cementstabilized/macadam',
    method: 'put',
    data: data
  })
}

// 删除水泥稳定碎石集料
export function delMacadam(id) {
  return request({
    url: '/cementstabilized/macadam/' + id,
    method: 'delete'
  })
}

export function getEchartData(data){
  return request({
    url: '/cementstabilized/macadam/queryBar',
    method: 'get',
    params: data
  })
}
