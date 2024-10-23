const express = require('express')
const fileUpload = require('express-fileupload')
const cors = require('cors')
const bodyParser = require('body-parser')
const morgan = require('morgan')
const _ = require('lodash')

const app = express()

app.use(fileUpload({
    createParentPath: true
}))

app.use(cors())
app.use(bodyParser.json())
app.use(bodyParser.urlencoded({ extended: true }))
app.use(morgan('dev'))

const port = process.env.PORT || 3000

app.listen(port, () =>
    console.log(`App is listening on port ${port}.`)
)

app.post('/upload', async (req, res) => {
    try {
        if (!req.files) {
            res.status(400).send({
                status: false,
                message: 'No file uploaded'
            })
        } else {
            let file = req.files.file
            file.mv('./uploads/' + file.name)
            res.send({
                status: true,
                message: 'File is uploaded',
                data: {
                    name: file.name,
                    mimetype: file.mimetype,
                    size: file.size
                }
            })
        }
    } catch (err) {
        res.status(500).send(err)
    }
})

app.post('/uploads', async (req, res) => {
    try {
        if (!req.files) {
            res.status(400).send({
                status: false,
                message: 'No file uploaded'
            })
        } else {
            let data = []
            _.forEach(_.keysIn(req.files.files), key => {
                let file = req.files.files[key]
                file.mv('./uploads/' + file.name)
                data.push({
                    name: file.name,
                    mimetype: file.mimetype,
                    size: file.size
                })
            })
            res.send({
                status: true,
                message: 'Files are uploaded',
                data: data
            })
        }
    } catch (err) {
        res.status(500).send(err)
    }
})

app.use(fileUpload({
    createParentPath: true,
    limits: { 
        fileSize: 10 * 1024 * 1024 * 1024
    },
}))