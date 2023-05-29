import request from '@/utils/request'

// 查询压力机列表
export function listStressmachine(query) {
  return request({
    url: '/machine/stressmachine/list',
    method: 'get',
    params: query
  })
}

// 查询压力机详细
export function getStressmachine(id) {
  return request({
    url: '/machine/stressmachine/' + id,
    method: 'get'
  })
}

// 新增压力机
export function addStressmachine(data) {
  return request({
    url: '/machine/stressmachine',
    method: 'post',
    data: data
  })
}

// 修改压力机
export function updateStressmachine(data) {
  return request({
    url: '/machine/stressmachine',
    method: 'put',
    data: data
  })
}

// 删除压力机
export function delStressmachine(id) {
  return request({
    url: '/machine/stressmachine/' + id,
    method: 'delete'
  })
}
