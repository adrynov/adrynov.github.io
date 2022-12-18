package com.adrynov.benchmarking.common

import java.io.File
import javax.sql.DataSource

sealed interface Error

sealed class IOError() : Error

class FileReadError(val f: File) : IOError()
class DatabaseError(val source: DataSource) : IOError()

object RuntimeError : Error