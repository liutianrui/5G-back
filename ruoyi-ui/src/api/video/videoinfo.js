import request from '@/utils/request'

// 查询视频监控信息列表
export function listVideoinfo(query) {
  return request({
    url: '/video/videoinfo/list',
    method: 'get',
    params: query
  })
}

// 查询视频监控信息详细
export function getVideoinfo(id) {
  return request({
    url: '/video/videoinfo/' + id,
    method: 'get'
  })
}

// 新增视频监控信息
export function addVideoinfo(data) {
  return request({
    url: '/video/videoinfo',
    method: 'post',
    data: data
  })
}

// 修改视频监控信息
export function updateVideoinfo(data) {
  return request({
    url: '/video/videoinfo',
    method: 'put',
    data: data
  })
}

// 删除视频监控信息
export function delVideoinfo(id) {
  return request({
    url: '/video/videoinfo/' + id,
    method: 'delete'
  })
}
