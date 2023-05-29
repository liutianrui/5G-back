import request from '@/utils/request'

// 查询软化点实验列表
export function listSofteningpoint(query) {
  return request({
    url: '/softening/softeningpoint/list',
    method: 'get',
    params: query
  })
}

// 查询软化点实验详细
export function getSofteningpoint(id) {
  return request({
    url: '/softening/softeningpoint/' + id,
    method: 'get'
  })
}

// 新增软化点实验
export function addSofteningpoint(data) {
  return request({
    url: '/softening/softeningpoint',
    method: 'post',
    data: data
  })
}

// 修改软化点实验
export function updateSofteningpoint(data) {
  return request({
    url: '/softening/softeningpoint',
    method: 'put',
    data: data
  })
}

// 删除软化点实验
export function delSofteningpoint(id) {
  return request({
    url: '/softening/softeningpoint/' + id,
    method: 'delete'
  })
}
