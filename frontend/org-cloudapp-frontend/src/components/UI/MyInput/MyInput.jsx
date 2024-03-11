import { faSearch } from '@fortawesome/free-solid-svg-icons'
import './MyInput.css'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'

export default function MyInput() {
    return (
        <div className='my-input-box'>
            <button type='submit'>
                <i className='fa fa-search'>
                    <FontAwesomeIcon icon={faSearch} />
                </i>
            </button>
            <input
                className='my-input'
                type='text'
                placeholder='Search file..'
            // value={ } 
            />

        </div>
    )
}