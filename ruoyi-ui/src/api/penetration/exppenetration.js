import request from '@/utils/request'

// 查询针入度实验列表
export function listExppenetration(query) {
  return request({
    url: '/penetration/exppenetration/list',
    method: 'get',
    params: query
  })
}

// 查询针入度实验详细
export function getExppenetration(id) {
  return request({
    url: '/penetration/exppenetration/' + id,
    method: 'get'
  })
}

// 新增针入度实验
export function addExppenetration(data) {
  return request({
    url: '/penetration/exppenetration',
    method: 'post',
    data: data
  })
}

// 修改针入度实验
export function updateExppenetration(data) {
  return request({
    url: '/penetration/exppenetration',
    method: 'put',
    data: data
  })
}

// 删除针入度实验
export function delExppenetration(id) {
  return request({
    url: '/penetration/exppenetration/' + id,
    method: 'delete'
  })
}
