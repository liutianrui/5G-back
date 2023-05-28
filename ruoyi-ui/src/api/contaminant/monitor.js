import request from '@/utils/request'

// 查询污染物监测器列表
export function listMonitor(query) {
  return request({
    url: '/contaminant/monitor/list',
    method: 'get',
    params: query
  })
}

// 查询污染物监测器详细
export function getMonitor(id) {
  return request({
    url: '/contaminant/monitor/' + id,
    method: 'get'
  })
}

// 新增污染物监测器
export function addMonitor(data) {
  return request({
    url: '/contaminant/monitor',
    method: 'post',
    data: data
  })
}

// 修改污染物监测器
export function updateMonitor(data) {
  return request({
    url: '/contaminant/monitor',
    method: 'put',
    data: data
  })
}

// 删除污染物监测器
export function delMonitor(id) {
  return request({
    url: '/contaminant/monitor/' + id,
    method: 'delete'
  })
}
