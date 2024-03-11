import { Navigate, Route, Routes } from 'react-router-dom'
import { routes } from '../../routes/routes'
import './AppRouter.css'
import MyInput from '../../components/UI/MyInput/MyInput'

export default function AppRouter() {
    return (
        <div className='app-router'>
            <div className='routes'>
                <MyInput />
                <Routes>
                    {
                        routes.map((route, index) => <Route
                            exact={route.exact}
                            path={route.path}
                            element={route.element}
                            key={index} />)
                    }
                    <Route path='*' element={<Navigate to='/' replace />} />
                </Routes>

            </div>
        </div>
    )
}