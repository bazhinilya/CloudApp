import Home from '../pages/AppRouter/Routes/Home'
import Recent from '../pages/AppRouter/Routes/Recent'
import Trash from '../pages/AppRouter/Routes/Trash'

export const routes = [
    { path: '/', element: <Home />, exact: true, name: 'Home' },
    { path: '/recent', element: <Recent />, exact: true, name: 'Recent' },
    { path: '/trash', element: <Trash />, exact: true, name: 'Trash' }
]