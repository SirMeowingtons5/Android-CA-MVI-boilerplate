package my.company.app.injection

import org.koin.dsl.module.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

val RouterModule = module{
    single("cicerone") { Cicerone.create() }

    factory { (get("cicerone") as Cicerone<Router>).router }
    factory { (get("cicerone") as Cicerone<Router>).navigatorHolder }
}