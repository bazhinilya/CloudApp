import axios from 'axios'

export const getAll = async (limit = 10, page = 1) =>
    await axios.get('http://localhost:8080/data', {
        params: {
            _limit: limit,
            _page: page
        }
    })