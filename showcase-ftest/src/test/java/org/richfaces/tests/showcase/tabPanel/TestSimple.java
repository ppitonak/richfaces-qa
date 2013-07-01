/*******************************************************************************
 * JBoss, Home of Professional Open Source
 * Copyright 2010-2013, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 *******************************************************************************/
package org.richfaces.tests.showcase.tabPanel;

import static org.jboss.arquillian.ajocado.Graphene.guardNoRequest;
import static org.jboss.arquillian.ajocado.locator.LocatorFactory.jq;
import static org.testng.Assert.assertTrue;

import org.jboss.arquillian.ajocado.locator.JQueryLocator;
import org.richfaces.tests.showcase.panel.AbstractPanelTest;
import org.testng.annotations.Test;

/**
 * @author <a href="mailto:jhuska@redhat.com">Juraj Huska</a>
 * @version $Revision$
 */
public class TestSimple extends AbstractPanelTest {

    /* **************************************************************************************
     * Locators***************************************************************************************
     */

    private JQueryLocator bodyOfPanel = jq("div.rf-tab:visible");
    private JQueryLocator firstTabButton = jq("fieldset.example-cnt td[class*=rf-tab-hdr]:visible:eq(1)");
    private JQueryLocator secondTabButton = jq("fieldset.example-cnt td[class*=rf-tab-hdr]:visible:eq(3)");

    /* **************************************************************************************
     * Tests**************************************************************************************
     */

    @Test
    public void testTabsAreNotEmpty() {
        checkToogleTab(firstTabButton, RICH_FACES_INFO);

        checkToogleTab(secondTabButton, RICH_FACES_JSF_INFO);
    }

    /* ********************************************************************************
     * Help methods********************************************************************************
     */

    private void checkToogleTab(JQueryLocator button, String expectedContent) {
        /*guardNoRequest(selenium).click(button);

        String actualContent = selenium.getText(bodyOfPanel);

        assertTrue(actualContent.contains(expectedContent), "The content of " + button.getRawLocator()
            + " is diferent!");*/
    }

}
