import request from '@/utils/request'

// 查询实验养护室列表
export function listCuringroom(query) {
  return request({
    url: '/experiment/curingroom/list',
    method: 'get',
    params: query
  })
}

// 查询实验养护室详细
export function getCuringroom(id) {
  return request({
    url: '/experiment/curingroom/' + id,
    method: 'get'
  })
}

// 新增实验养护室
export function addCuringroom(data) {
  return request({
    url: '/experiment/curingroom',
    method: 'post',
    data: data
  })
}

// 修改实验养护室
export function updateCuringroom(data) {
  return request({
    url: '/experiment/curingroom',
    method: 'put',
    data: data
  })
}

// 删除实验养护室
export function delCuringroom(id) {
  return request({
    url: '/experiment/curingroom/' + id,
    method: 'delete'
  })
}
