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

package org.ecorous.calcium;

import net.neoforged.neoforge.common.ModConfigSpec;

public class CalciumConfig {
    public ModConfigSpec.ConfigValue<Integer> potionTime;
    public ModConfigSpec.ConfigValue<Integer> potionAmplifier;
    public ModConfigSpec.ConfigValue<String> potionId;
    public CalciumConfig(ModConfigSpec.Builder builder) {
        builder.comment("Calcium configuration");
        potionTime = builder.define("potionTime", 300);
        potionAmplifier = builder.define("potionAmplifier", 1);
        potionId = builder.define("potionId", "minecraft:strength");
    }
}
