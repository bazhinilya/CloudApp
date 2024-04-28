import axios from 'axios'

export const getDirectoryById = async (id)=> await axios.get(`http://localhost:8080/cd/${id}`)
// export const getAll = async (user, name) => await axios.get(`http://localhost:8080/${user}/folder/${name}`)