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
package org.richfaces.tests.showcase.popup;

import static org.jboss.arquillian.ajocado.Graphene.guardNoRequest;
import static org.jboss.arquillian.ajocado.locator.LocatorFactory.jq;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.jboss.arquillian.ajocado.locator.JQueryLocator;
import org.jboss.arquillian.graphene.enricher.findby.ByJQuery;
import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.jboss.arquillian.graphene.spi.annotations.Page;
import org.openqa.selenium.WebElement;
import org.richfaces.tests.showcase.panel.AbstractPanelTest;
import org.richfaces.tests.showcase.popup.page.PopupPage;
import org.testng.annotations.Test;

/**
 * @author <a href="mailto:jhuska@redhat.com">Juraj Huska</a>
 * @version $Revision$
 */
public class TestSimplePopup extends AbstractPanelTest {

    private final String BODY_OF_THE_POPUP = "Any content might be inside this panel.\n"
        + " The popup panel is open and closed from the javascript function of component client side object. "
        + "The following code hide this panel: #{rich:component('popup')}.hide()";

    @Page
    private PopupPage page;

    @FindBy(jquery = "div[class*='rf-pp-cnt']:visible a")
    private WebElement popupPanelHideAnchor;

    @Test
    public void testCallTheNonModalPopupAndHideIt() {
        page.callthePopupButton.click();
        WebElement content = webDriver.findElement(ByJQuery.jquerySelector("div[class*='rf-pp-cnt']:visible"));
        assertTrue(content.isDisplayed(), "The panel should be visible!");
        checkContentOfPanel(content.getText(), BODY_OF_THE_POPUP);
        page.anchorOfSource.click();
        assertTrue(page.sourceOfPage.isDisplayed(), "The source of the page should be visible, since "
            + "the poppup panel is not modal, and therefore clicking on the source should show the source");
        assertTrue(content.isDisplayed(), "The panel should not disappear when clicking somewhere else!");
        popupPanelHideAnchor.click();
        assertFalse(content.isDisplayed(), "The poppup panel should not be visible, since there was a click " + "on the hide anchor!");
    }

}
