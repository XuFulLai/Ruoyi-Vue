import request from '@/utils/request'

// 查询技能岗位计划列表
export function listRecruitment(query) {
  return request({
    url: '/bussiness/recruitment/list',
    method: 'get',
    params: query
  })
}

// 查询技能岗位计划详细
export function getRecruitment(id) {
  return request({
    url: '/bussiness/recruitment/' + id,
    method: 'get'
  })
}

// 新增技能岗位计划
export function addRecruitment(data) {
  return request({
    url: '/bussiness/recruitment',
    method: 'post',
    data: data
  })
}

// 修改技能岗位计划
export function updateRecruitment(data) {
  return request({
    url: '/bussiness/recruitment',
    method: 'put',
    data: data
  })
}

// 删除技能岗位计划
export function delRecruitment(unitName) {
  return request({
    url: '/bussiness/recruitment/' + unitName,
    method: 'delete'
  })
}
