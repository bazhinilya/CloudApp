import axios from 'axios'

export const getAll = async (page) => await axios.get(`http://localhost:8080/data/files/${page}`)