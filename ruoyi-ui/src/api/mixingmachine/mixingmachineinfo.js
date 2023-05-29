import request from '@/utils/request'

// 查询搅拌机信息列表
export function listMixingmachineinfo(query) {
  return request({
    url: '/mixingmachine/mixingmachineinfo/list',
    method: 'get',
    params: query
  })
}

// 查询搅拌机信息详细
export function getMixingmachineinfo(mixingmachineId) {
  return request({
    url: '/mixingmachine/mixingmachineinfo/' + mixingmachineId,
    method: 'get'
  })
}

// 新增搅拌机信息
export function addMixingmachineinfo(data) {
  return request({
    url: '/mixingmachine/mixingmachineinfo',
    method: 'post',
    data: data
  })
}

// 修改搅拌机信息
export function updateMixingmachineinfo(data) {
  return request({
    url: '/mixingmachine/mixingmachineinfo',
    method: 'put',
    data: data
  })
}

// 删除搅拌机信息
export function delMixingmachineinfo(mixingmachineId) {
  return request({
    url: '/mixingmachine/mixingmachineinfo/' + mixingmachineId,
    method: 'delete'
  })
}
