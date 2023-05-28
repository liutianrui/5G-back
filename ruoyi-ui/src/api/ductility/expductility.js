import request from '@/utils/request'

// 查询延展性实验列表
export function listExpductility(query) {
  return request({
    url: '/ductility/expductility/list',
    method: 'get',
    params: query
  })
}

// 查询延展性实验详细
export function getExpductility(id) {
  return request({
    url: '/ductility/expductility/' + id,
    method: 'get'
  })
}

// 新增延展性实验
export function addExpductility(data) {
  return request({
    url: '/ductility/expductility',
    method: 'post',
    data: data
  })
}

// 修改延展性实验
export function updateExpductility(data) {
  return request({
    url: '/ductility/expductility',
    method: 'put',
    data: data
  })
}

// 删除延展性实验
export function delExpductility(id) {
  return request({
    url: '/ductility/expductility/' + id,
    method: 'delete'
  })
}
