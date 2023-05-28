import request from '@/utils/request'

// 查询实验炉列表
export function listExpfurnace(query) {
  return request({
    url: '/furnace/expfurnace/list',
    method: 'get',
    params: query
  })
}

// 查询实验炉详细
export function getExpfurnace(id) {
  return request({
    url: '/furnace/expfurnace/' + id,
    method: 'get'
  })
}

// 新增实验炉
export function addExpfurnace(data) {
  return request({
    url: '/furnace/expfurnace',
    method: 'post',
    data: data
  })
}

// 修改实验炉
export function updateExpfurnace(data) {
  return request({
    url: '/furnace/expfurnace',
    method: 'put',
    data: data
  })
}

// 删除实验炉
export function delExpfurnace(id) {
  return request({
    url: '/furnace/expfurnace/' + id,
    method: 'delete'
  })
}
