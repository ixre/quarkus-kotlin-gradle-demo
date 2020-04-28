/**
 * this file is auto generated by TTO-CodeGenerator v{{.global.Version}} !
 * if you want to modify this code,please read guide doc
 * and modify code template later.
 *
 * guide please see https://github.com/ixre/tto
 *
 */
#target!spring/src/main/kotlin/{{.global.Pkg}}/repo/{{.table.Title}}JpaRepository.kt
package {{pkg "java" .global.Pkg}}.repo;

import {{pkg "kotlin" .global.Pkg}}.pojo.{{.table.Title}}Entity
import org.springframework.data.jpa.repository.JpaRepository
{{$pkType := type "kotlin" .table.PkTypeId}}
/** {{.table.Comment}}仓储接口  */
interface {{.table.Title}}JpaRepository : JpaRepository<{{.table.Title}}Entity, {{$pkType}}> {

}