package ru.soft.companywarnings

import javax.inject.Inject

class TestClass @Inject constructor(private val test2Class: Test2Class) {
}


class Test2Class @Inject constructor() {

}