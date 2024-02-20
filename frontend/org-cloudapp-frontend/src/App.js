import './App.css'
import AppRouter from './pages/AppRouter'
import Sidebar from './components/Sidebar'

export default function App() {
  return <div className='app'>
    <Sidebar />
    <AppRouter />
  </div>
}