import './MyInput.css'
import { faSearch } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'

export default function MyInput(props) {
    return (
        <div style={{ padding: 10 }}>


            <div className='search'>

                <FontAwesomeIcon className='search-icon' icon={faSearch} />
                <input
                    className='search-input'
                    type='search'
                    placeholder='Search file..'
                    // value={ }
                    {...props}
                />
            </div>
        </div>
    )
}