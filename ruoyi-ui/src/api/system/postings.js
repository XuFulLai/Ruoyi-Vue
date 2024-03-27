import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listPostings(query) {
  return request({
    url: '/system/postings/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getPostings(id) {
  return request({
    url: '/system/postings/' + id,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addPostings(data) {
  return request({
    url: '/system/postings',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updatePostings(data) {
  return request({
    url: '/system/postings',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delPostings(id) {
  return request({
    url: '/system/postings/' + id,
    method: 'delete'
  })
}
