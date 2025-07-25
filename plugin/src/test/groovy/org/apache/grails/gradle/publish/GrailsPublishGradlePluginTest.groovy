/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.apache.grails.gradle.publish

import org.gradle.testfixtures.ProjectBuilder
import spock.lang.Specification

class GrailsPublishGradlePluginTest extends Specification {

    def 'plugin registers release task for release version'() {
        given:
        def project = ProjectBuilder.builder().build()
        project.version = '1.0.0'

        when:
        project.plugins.apply('org.apache.grails.gradle.grails-publish')

        then:
        project.tasks.findByName('retrieveSonatypeStagingProfile') != null
    }

    def 'plugin registers release task for snapshot version'() {
        given:
        def project = ProjectBuilder.builder().build()
        project.version = '1.0.0-SNAPSHOT'

        when:
        project.plugins.apply('org.apache.grails.gradle.grails-publish')

        then:
        project.tasks.findByName('publish') != null
    }
}
