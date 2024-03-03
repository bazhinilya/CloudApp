import './App.css'
import AppRouter from './AppRouter/AppRouter'
import Sidebar from '../components/sidebar/Sidebar'

export default function App() {
  return (
    <div>

      <div className='split right'>
        <Sidebar />
      </div>

      <div className=' split left'>
        <AppRouter />
      </div>

    </div>
  )
}