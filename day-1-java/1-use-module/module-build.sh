#!/usr/bin/bash
javac \
    -d build/com.levinine.codenine.modules.first.dependency \
    src/main/java/com.levinine.codenine.modules.first.dependency/module-info.java \
    src/main/java/com.levinine.codenine.modules.first.dependency/com/levinine/codenine/modules/first/dependency/util/Prompt.java \
    src/main/java/com.levinine.codenine.modules.first.dependency/com/levinine/codenine/modules/first/dependency/TextPrinter.java

jar --create \
    --file=build/mlib/com.levinine.codenine.modules.first.dependency@1.0.jar \
    --module-version=1.0 \
    -C build/com.levinine.codenine.modules.first.dependency \
    .

javac --module-path build \
    -d build/com.levinine.codenine.modules.first.usage \
    src/main/java/com.levinine.codenine.modules.first.usage/module-info.java \
    src/main/java/com.levinine.codenine.modules.first.usage/com/levinine/codenine/modules/first/usage/Terminal.java

jar --create \
    --file=build/mlib/com.levinine.codenine.modules.first.usage.jar \
    --main-class=com.levinine.codenine.modules.first.usage.Terminal \
    -C build/com.levinine.codenine.modules.first.usage \
    .