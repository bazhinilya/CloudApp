import Home from '../pages/Home'
import Recent from '../pages/Recent'
import Trash from '../pages/Trash'

export const routes = [
    { path: '/', element: <Home />, exact: true, name: 'Home' },
    { path: '/recent', element: <Recent />, exact: true, name: 'Recent' },
    { path: '/trash', element: <Trash />, exact: true, name: 'Trash' }
]