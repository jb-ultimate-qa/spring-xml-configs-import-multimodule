
**Regressions after performance improvements:**
Not repeatable in the master branch:
- https://youtrack.jetbrains.com/issue/IDEA-384663/Spring-xml-import-beans-from-resources-without-classpath-classpath-prefixes-are-not-resolved: use for example the 
 `app-module/src/main/resources/moduleApp/nested/to_upper_level.xml`,
 `app-module/src/main/resources/no_prefix.xml` or `web-module/src/main/webapp/WEB-INF/application-context.xml`

- https://youtrack.jetbrains.com/issue/IDEA-384665/Spring-xml-import-resources-are-not-resolved-if-referenced-from-the-module-that-doesnt-have-them-in-its-classpath: 
 use the `module-c/src/main/resources/import_from_submodule.xml` file
   
**Old problems:**
Repeatable both in master and in branch:
- https://youtrack.jetbrains.com/issue/IDEA-384666/Spring-xml-import-if-classpath-prefix-is-used-only-current-module-resources-should-be-available: see the `app-module/src/main/resources/all_in_module.xml`
- https://youtrack.jetbrains.com/issue/IDEA-384668/Spring-xml-import-if-classpath-prefix-is-missed-only-resources-from-current-module-should-be-available: use for example the
  `app-module/src/main/resources/moduleApp/nested/to_upper_level.xml` or `app-module/src/main/resources/no_prefix.xml`
- https://youtrack.jetbrains.com/issue/IDEA-384669/Spring-xml-import-file-protocol-prefix-should-be-supported: use `app-module/src/main/resources/file_protocol.xml`
- files from `src` roots should not be availabe in import - see `app-module/src/main/resources/files_from_src.xml`

**More import cases:**
- `qa-jar` directories: imports of Spring XML files from library jars ([spring-xml-lib](https://github.com/jb-ultimate-qa/spring-xml-lib) and `cxf-core`)
- `app-module/src/test/resources/qa-test`: imports in test resources
- `app-module/src/main/resources/qa-test-neg`: a main configuration that imports a test resource

The comments in each file show which beans are expected to be resolved.