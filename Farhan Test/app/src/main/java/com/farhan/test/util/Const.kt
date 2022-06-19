package com.farhan.test.util

object Const {
    object Network {
        const val PREFIX_GENERAL = "v1/general/"
        const val PREFIX = "v1/"

        object Home {
            const val PRODUCT = PREFIX + "storages/5e1edf521073e315924ceab4/list"
            const val AREA = PREFIX + "storages/5e1edf521073e315924ceab4/option_area"
        }

    }

    object Access {
        const val AUTH_PREFIX = "Bearer"
    }

    object Database {
        const val DATABASE_NAME = "EFISHERY_DATABASE"

        object Table {
            const val ORDER = "order_entity"
            const val STOCK = "stock_entity"
        }
    }

    object DataStore{
        const val TOKEN = "TOKEN_KEY"
        const val USERNAME = "USERNAME"
    }

    object File {
        object Location {
            const val basePath = "Efishery/"
            const val storePath = "PARENTINGHUB/"
        }

        object MimeType {
            const val image = "image/jpeg"
            const val pdf = "application/pdf"
        }

        object Image {
            const val defaultFileName = "EFISHERY-Image"
        }

        object Pending {
            const val isPending = 1
            const val notPending = 0
        }
    }
}