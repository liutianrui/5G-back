import request from '@/utils/request'

// 查询污染物排放列表
export function listPollutantdict(query) {
  return request({
    url: '/pollutant/pollutantdict/list',
    method: 'get',
    params: query
  })
}

// 查询污染物排放详细
export function getPollutantdict(id) {
  return request({
    url: '/pollutant/pollutantdict/' + id,
    method: 'get'
  })
}

// 新增污染物排放
export function addPollutantdict(data) {
  return request({
    url: '/pollutant/pollutantdict',
    method: 'post',
    data: data
  })
}

// 修改污染物排放
export function updatePollutantdict(data) {
  return request({
    url: '/pollutant/pollutantdict',
    method: 'put',
    data: data
  })
}

// 删除污染物排放
export function delPollutantdict(id) {
  return request({
    url: '/pollutant/pollutantdict/' + id,
    method: 'delete'
  })
}
