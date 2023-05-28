import request from '@/utils/request'

// 查询马歇尔稳定性实验列表
export function listMarshallstability(query) {
  return request({
    url: '/marshall/marshallstability/list',
    method: 'get',
    params: query
  })
}

// 查询马歇尔稳定性实验详细
export function getMarshallstability(id) {
  return request({
    url: '/marshall/marshallstability/' + id,
    method: 'get'
  })
}

// 新增马歇尔稳定性实验
export function addMarshallstability(data) {
  return request({
    url: '/marshall/marshallstability',
    method: 'post',
    data: data
  })
}

// 修改马歇尔稳定性实验
export function updateMarshallstability(data) {
  return request({
    url: '/marshall/marshallstability',
    method: 'put',
    data: data
  })
}

// 删除马歇尔稳定性实验
export function delMarshallstability(id) {
  return request({
    url: '/marshall/marshallstability/' + id,
    method: 'delete'
  })
}
