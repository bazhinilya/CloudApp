import Home from '../pages/AppRouter/Routes/Home/Home'
import Recent from '../pages/AppRouter/Routes/Recent/Recent'
import Trash from '../pages/AppRouter/Routes/Trash/Trash'

export const routes = [
    { path: '/', element: <Home />, exact: true, name: 'My Cloud' },
    { path: '/recent', element: <Recent />, exact: true, name: 'Recent file' },
    { path: '/trash', element: <Trash />, exact: true, name: 'Trash file' }
]