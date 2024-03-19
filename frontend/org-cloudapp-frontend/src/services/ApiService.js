import axios from 'axios'

export const getDefaultFolder = async (user)=> await axios.get(`http://localhost:8080/${user}`)
export const getAll = async (user, name) => await axios.get(`http://localhost:8080/${user}/folder/${name}`)