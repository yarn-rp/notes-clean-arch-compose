package com.example.myapplication.domain.util

/**
 * Base class for all use cases.
 * @param Params the input parameters to run the use case.
 * @param Result the type of the result of the use case.
 */
abstract class UseCase<Params,Result> {
    abstract suspend operator fun invoke(params: Params): Result
}