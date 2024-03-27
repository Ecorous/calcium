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

import org.ecorous.calcium.platform.services.IPlatformHelper
import net.neoforged.fml.ModList
import net.neoforged.fml.loading.FMLLoader

class NeoForgePlatformHelper : IPlatformHelper {
    override val platformName: String = "NeoForge"

    override fun isModLoaded(modId: String?): Boolean = ModList.get().isLoaded(modId)


    override val isDevelopmentEnvironment: Boolean
        get() = !FMLLoader.isProduction()
}