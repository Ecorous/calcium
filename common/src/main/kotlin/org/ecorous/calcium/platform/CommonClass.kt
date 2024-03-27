/*
 * Copyright 2024 Ecorous
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ecorous.calcium.platform


import org.ecorous.calcium.Constants
import org.ecorous.calcium.platform.Services
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.item.Items
import net.neoforged.neoforge.common.ModConfigSpec
import org.ecorous.calcium.CalciumConfig
import org.apache.commons.lang3.tuple.Pair

// This class is part of the common project meaning it is shared between all supported loaders. Code written here can only
// import and access the vanilla codebase, libraries used by vanilla, and optionally third party libraries that provide
// common compatible binaries. This means common code can not directly use loader specific concepts such as Forge events
// however it will be compatible with all supported mod loaders.
object CommonClass {
    lateinit var config: Pair<CalciumConfig, ModConfigSpec>
    // The loader specific projects are able to import and use any code from the common project. This allows you to
    // write the majority of your code here and load it from your loader specific projects. This example has some
    // code that gets invoked by the entry point of the loader specific projects.
    fun init() {
        Constants.LOG.info(
            "Hello from Common init on {}! we are currently in a {} environment!",
            Services.PLATFORM.platformName,
            Services.PLATFORM.environmentName
        )
        Constants.LOG.info("The ID for diamonds is {}", BuiltInRegistries.ITEM.getKey(Items.DIAMOND))

        // It is common for all supported loaders to provide a similar feature that can not be used directly in the
        // common code. A popular way to get around this is using Java's built-in service loader feature to create
        // your own abstraction layer. You can learn more about this in our provided services class. In this example
        // we have an interface in the common code and use a loader specific implementation to delegate our call to
        // the platform specific approach.
        if (Services.PLATFORM.isModLoaded("examplemod")) {
            Constants.LOG.info("Hello to examplemod")
        }
    }

    fun setupConfig() {
        config = ModConfigSpec.Builder().configure(::CalciumConfig)
    }
}