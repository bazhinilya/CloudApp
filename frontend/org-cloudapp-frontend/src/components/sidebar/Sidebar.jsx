import './Sidebar.css'
import { Link } from 'react-router-dom'
import { routes } from '../../routes/routes'
import { icons } from '../../assets/icons'

export default function Sidebar() {
    return (
        <div className='sidebar'>

            <img alt='logo' />
            <h1>CloudApp</h1>

            <div className='sidebar__links'>
                {
                    routes.map((route, index) =>
                        <Link to={route.path} key={route.name}>
                            <div className='sidebar__links__link'>
                                {icons[index].icon}
                                <span />
                                {route.name}
                            </div>
                        </Link>)
                }
            </div>

        </div>
    )
}