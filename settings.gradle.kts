@file:Suppress("NOTHING_TO_INLINE")

rootProject.name = "app-android"

fun module(path: String) {
    val i = path.lastIndexOf('/')
    val name = path.substring(i + 1)
    include(name)
    project(":$name").projectDir = File(path)
}

fun base(name: String) = module("./sources/base/$name")
fun feature(name: String) = module("./sources/features/$name")

base("app")
base("domain")
base("data")
base("presentation")
base("coreui")

feature("launcher")
feature("mainscreen")