import request from '@/utils/request'

// 查询地磅列表
export function listBridge(query) {
  return request({
    url: '/weigh/bridge/list',
    method: 'get',
    params: query
  })
}

// 查询地磅详细
export function getBridge(id) {
  return request({
    url: '/weigh/bridge/' + id,
    method: 'get'
  })
}

// 新增地磅
export function addBridge(data) {
  return request({
    url: '/weigh/bridge',
    method: 'post',
    data: data
  })
}

// 修改地磅
export function updateBridge(data) {
  return request({
    url: '/weigh/bridge',
    method: 'put',
    data: data
  })
}

// 删除地磅
export function delBridge(id) {
  return request({
    url: '/weigh/bridge/' + id,
    method: 'delete'
  })
}

export function getBarEcharts (data) {
  return request({
    url: '/weigh/bridge/queryBar',
    method: 'get',
    params: data
  })
}

export function getPieEcharts (data) {
  return request({
    url: '/weigh/bridge/queryPie',
    method: 'get',
    params: data
  })
}
