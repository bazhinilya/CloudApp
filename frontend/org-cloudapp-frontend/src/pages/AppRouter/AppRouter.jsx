import './AppRouter.css'
import { Navigate, Route, Routes } from 'react-router-dom'
import { routes } from '../../routes/routes'
import MyInput from '../../components/UI/MyInput/MyInput'
import WorkField from './WorkField/WorkField'

export default function AppRouter() {
    return (
        <div className='app-router'>
            <MyInput />
            <Routes>
                {
                    routes.map((route, index) => <Route
                        exact={route.exact}
                        path={route.path}
                        element={<WorkField name={route.name}/>}
                        key={index} />)
                }
                <Route path='*' element={<Navigate to='/' replace />} />
            </Routes>
        </div>
    )
}