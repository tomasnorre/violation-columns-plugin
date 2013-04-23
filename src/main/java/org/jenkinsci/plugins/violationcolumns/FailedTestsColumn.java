package org.jenkinsci.plugins.violationcolumns;

import hudson.Extension;
import hudson.model.Descriptor;
import hudson.views.ListViewColumnDescriptor;
import hudson.views.ListViewColumn;
import net.sf.json.JSONObject;

import org.kohsuke.stapler.StaplerRequest;

public final class FailedTestsColumn extends ListViewColumn {

    /**
     * The plugin descriptor.
     */
    private static final class FailedTestsColumnDescriptor extends
            ListViewColumnDescriptor {
        @Override
        public String getDisplayName() {
            return "Failed Tests Count";
        }

        @Override
        public ListViewColumn newInstance(final StaplerRequest request,
                final JSONObject formData) throws FormException {
            return new FailedTestsColumn();
        }

        @Override
        public boolean shownByDefault() {
            return false;
        }
    }

    /**
     * The plugin descriptor.
     */
    @Extension
    public static final Descriptor<ListViewColumn> DESCRIPTOR = new FailedTestsColumnDescriptor();

    @Override
    public Descriptor<ListViewColumn> getDescriptor() {
        return DESCRIPTOR;
    }
}
