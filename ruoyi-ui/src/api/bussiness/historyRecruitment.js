import request from '@/utils/request'

// 查询历年岗位信息列表
export function listHistoryRecruitment(query) {
  return request({
    url: '/system/historyRecruitment/list',
    method: 'get',
    params: query
  })
}

// 查询历年岗位信息详细
export function getHistoryRecruitment(id) {
  return request({
    url: '/system/historyRecruitment/' + id,
    method: 'get'
  })
}

// 新增历年岗位信息
export function addHistoryRecruitment(data) {
  return request({
    url: '/system/historyRecruitment',
    method: 'post',
    data: data
  })
}

// 修改历年岗位信息
export function updateHistoryRecruitment(data) {
  return request({
    url: '/system/historyRecruitment',
    method: 'put',
    data: data
  })
}

// 删除历年岗位信息
export function delHistoryRecruitment(jobCode) {
  return request({
    url: '/system/historyRecruitment/' + jobCode,
    method: 'delete'
  })
}
