import request from '@/utils/request'

// 查询水泥稳定碎石集料列表
export function listCementstabilized(query) {
  return request({
    url: '/cementstabilized/cementstabilized/list',
    method: 'get',
    params: query
  })
}

// 查询水泥稳定碎石集料详细
export function getCementstabilized(id) {
  return request({
    url: '/cementstabilized/cementstabilized/' + id,
    method: 'get'
  })
}

// 新增水泥稳定碎石集料
export function addCementstabilized(data) {
  return request({
    url: '/cementstabilized/cementstabilized',
    method: 'post',
    data: data
  })
}

// 修改水泥稳定碎石集料
export function updateCementstabilized(data) {
  return request({
    url: '/cementstabilized/cementstabilized',
    method: 'put',
    data: data
  })
}

// 删除水泥稳定碎石集料
export function delCementstabilized(id) {
  return request({
    url: '/cementstabilized/cementstabilized/' + id,
    method: 'delete'
  })
}
